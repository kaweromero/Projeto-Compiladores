/* Generated By:JJTree: Do not edit this line. expression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class expression extends CustomNode {
  public expression(int id) {
    super(id);
  }

  public expression(Analisador p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AnalisadorVisitor visitor, Controlador data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0efddcba2bed78ccd1d3e14341b22e53 (do not edit this line) */