/* Generated By:JJTree: Do not edit this line. goal.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class goal extends CustomNode {
  public goal(int id) {
    super(id);
  }

  public goal(Analisador p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AnalisadorVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=371480376ca393b6c4133f93cc498576 (do not edit this line) */