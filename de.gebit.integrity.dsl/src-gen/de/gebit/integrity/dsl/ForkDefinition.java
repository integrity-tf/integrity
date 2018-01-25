/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fork Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ForkDefinition#getPrivate <em>Private</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ForkDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ForkDefinition#getForkerClass <em>Forker Class</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ForkDefinition#getBaseFork <em>Base Fork</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ForkDefinition#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition()
 * @model
 * @generated
 */
public interface ForkDefinition extends Statement, PackageStatement
{
  /**
   * Returns the value of the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Private</em>' attribute.
   * @see #setPrivate(String)
   * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition_Private()
   * @model
   * @generated
   */
  String getPrivate();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkDefinition#getPrivate <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private</em>' attribute.
   * @see #getPrivate()
   * @generated
   */
  void setPrivate(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkDefinition#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Forker Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forker Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forker Class</em>' containment reference.
   * @see #setForkerClass(JavaClassReference)
   * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition_ForkerClass()
   * @model containment="true"
   * @generated
   */
  JavaClassReference getForkerClass();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkDefinition#getForkerClass <em>Forker Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Forker Class</em>' containment reference.
   * @see #getForkerClass()
   * @generated
   */
  void setForkerClass(JavaClassReference value);

  /**
   * Returns the value of the '<em><b>Base Fork</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Fork</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Fork</em>' reference.
   * @see #setBaseFork(ForkDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition_BaseFork()
   * @model
   * @generated
   */
  ForkDefinition getBaseFork();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkDefinition#getBaseFork <em>Base Fork</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Fork</em>' reference.
   * @see #getBaseFork()
   * @generated
   */
  void setBaseFork(ForkDefinition value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ForkParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getForkDefinition_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ForkParameter> getParameters();

} // ForkDefinition
