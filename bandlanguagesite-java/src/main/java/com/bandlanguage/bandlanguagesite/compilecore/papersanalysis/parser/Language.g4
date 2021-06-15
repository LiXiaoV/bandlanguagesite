grammar Language;

script: (stmt Dot?)+;
stmt: simpleStmt;
simpleStmt: subject_predicate_object_stmt;
subject_predicate_object_stmt: subject? predicate object;
subject: Me | Identifier;
predicate: verb;
object: Number | String | Identifier | noun;

noun: Paper | Abstract;
verb: Add;

Paper: '论文';
Abstract: '摘要';
Add: '添加';

Me: '我';

Comma: ',' | '，';
Dot :'.'|'。';
Number :[0-9]+;
String: '‘' (.)*? '’';

Identifier: ([a-zA-Z0-9$_] | [\u4E00-\u9FA5])+;
Ws :[ \t\r\n]+ -> skip;
Comment :'//' ~[\r\n]* -> channel(HIDDEN);