/**
 */
package org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.GuardExpression#getGuardExpr <em>Guard Expr</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage#getGuardExpression()
 * @model
 * @generated
 */
public interface GuardExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Guard Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard Expr</em>' containment reference.
   * @see #setGuardExpr(Expression)
   * @see org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage#getGuardExpression_GuardExpr()
   * @model containment="true"
   * @generated
   */
  Expression getGuardExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.GuardExpression#getGuardExpr <em>Guard Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard Expr</em>' containment reference.
   * @see #getGuardExpr()
   * @generated
   */
  void setGuardExpr(Expression value);

} // GuardExpression
