/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visible Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.VisibleComment#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getVisibleComment()
 * @model
 * @generated
 */
public interface VisibleComment extends SuiteStatement
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(String)
   * @see de.gebit.integrity.dsl.DslPackage#getVisibleComment_Content()
   * @model
   * @generated
   */
  String getContent();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.VisibleComment#getContent <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(String value);

} // VisibleComment
