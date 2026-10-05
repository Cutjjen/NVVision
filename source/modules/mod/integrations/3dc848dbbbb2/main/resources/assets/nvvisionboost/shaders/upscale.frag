#version 150
uniform sampler2D Source;
uniform vec2 SourceSize;
uniform float Sharpness;
uniform int Mode;
in vec2 TexCoord;
out vec4 FragColor;

<<<<<<< HEAD
// Separable Catmull-Rom: combine the two central weights into one bilinear sample.
=======
// Catmull-Rom separável: combina os dois pesos centrais em uma amostra bilinear.
>>>>>>> origin/master
vec3 cubic(vec2 uv) {
    vec2 position = uv * SourceSize - 0.5;
    vec2 base = floor(position), f = position - base;
    vec2 f2 = f * f, f3 = f2 * f;
    vec2 w0 = -0.5 * f + f2 - 0.5 * f3;
    vec2 w1 = 1.0 - 2.5 * f2 + 1.5 * f3;
    vec2 w2 = 0.5 * f + 2.0 * f2 - 1.5 * f3;
    vec2 w3 = -0.5 * f2 + 0.5 * f3;
    vec2 middle = w1 + w2;
    vec3 wx = vec3(w0.x, middle.x, w3.x);
    vec3 wy = vec3(w0.y, middle.y, w3.y);
    vec3 px = (vec3(base.x - 1.0, base.x + w2.x / middle.x, base.x + 2.0) + 0.5) / SourceSize.x;
    vec3 py = (vec3(base.y - 1.0, base.y + w2.y / middle.y, base.y + 2.0) + 0.5) / SourceSize.y;
    vec3 value = vec3(0.0);
    for (int y = 0; y < 3; ++y)
        for (int x = 0; x < 3; ++x)
            value += texture(Source, vec2(px[x], py[y])).rgb * wx[x] * wy[y];
    return value;
}

void main() {
    vec2 pixel = 1.0 / SourceSize;
    vec4 original = texture(Source, TexCoord);
    vec3 center = Mode == 2 ? cubic(TexCoord) : original.rgb;
    vec3 n = texture(Source, TexCoord + vec2(0.0, pixel.y)).rgb;
    vec3 s = texture(Source, TexCoord - vec2(0.0, pixel.y)).rgb;
    vec3 e = texture(Source, TexCoord + vec2(pixel.x, 0.0)).rgb;
    vec3 w = texture(Source, TexCoord - vec2(pixel.x, 0.0)).rgb;
    vec3 lo = min(original.rgb, min(min(n, s), min(e, w)));
    vec3 hi = max(original.rgb, max(max(n, s), max(e, w)));
    center = clamp(center, lo, hi);
<<<<<<< HEAD
    // Limit edge halos and avoid amplifying near-black or near-white extremes.
=======
    // Limita halos em bordas e evita amplificar extremos próximos de preto/branco.
>>>>>>> origin/master
    vec3 amplitude = sqrt(clamp(min(lo, 1.0 - hi) / max(hi, vec3(0.0001)), 0.0, 1.0));
    vec3 weight = -0.19 * clamp(Sharpness, 0.0, 1.0) * amplitude;
    vec3 sharpened = (center + weight * (n + s + e + w)) / (1.0 + 4.0 * weight);
    FragColor = vec4(clamp(sharpened, lo, hi), original.a);
}
