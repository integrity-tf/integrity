/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.DocumentationComment#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getDocumentationComment()
 * @model
 * @generated
 */
public interface DocumentationComment extends EObject
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(String)
   * @see de.gebit.integrity.dsl.DslPackage#getDocumentationComment_Content()
   * @model
   * @generated
   */
  String getContent();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.DocumentationComment#getContent <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(String value);

} // DocumentationComment
