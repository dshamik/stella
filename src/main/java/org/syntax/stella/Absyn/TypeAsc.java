// File generated by the BNF Converter (bnfc 2.9.4.1).

package org.syntax.stella.Absyn;

public class TypeAsc  extends Expr {
  public final Expr expr_;
  public final Type type_;
  public int line_num, col_num, offset;
  public TypeAsc(Expr p1, Type p2) { expr_ = p1; type_ = p2; }

  public <R,A> R accept(org.syntax.stella.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.syntax.stella.Absyn.TypeAsc) {
      org.syntax.stella.Absyn.TypeAsc x = (org.syntax.stella.Absyn.TypeAsc)o;
      return this.expr_.equals(x.expr_) && this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.expr_.hashCode())+this.type_.hashCode();
  }


}
