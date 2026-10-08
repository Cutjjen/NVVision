from pathlib import Path
import json,re,hashlib,collections
p=Path('.');d=json.loads((p/'config/sources.json').read_text());sources=sorted({e['source'] for e in d});keys=collections.Counter((e['target'],e['kind'],e['path']) for e in d);assert all(v==1 for v in keys.values()),'Duplicate source bindings'
issues=[]
for src in sources:
 f=p/'source'/src;s=f.read_text(encoding='utf-8-sig') if f.suffix=='.java' else ''
 if re.search(r'(?m)^(<<<<<<<|=======|>>>>>>>)',s):issues.append((src,'merge marker'))
 if re.search(r'NVVision Addon \d',s):issues.append((src,'stale addon report version'))
 if src.endswith('NeoForgeBridge.java') and 'Client bridge:' in s and 'inspected = true;' not in s:issues.append((src,'repeating bridge inspection'))
 for token in re.findall(r'"(?:\\.|[^"\\])*"|\'(?:\\.|[^\'\\])*\'|//[^\n]*|/\*.*?\*/',s,re.S):
  if token.startswith(('//','/*')) and re.search('[áéíóúãõçê]',token):issues.append((src,'non-English implementation comment'))
assert not issues,issues
print('PASS source hygiene:',len(sources),'registered files; no duplicate bindings, conflict markers, stale report versions or non-English comments')
