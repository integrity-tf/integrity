/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getLive <em>Live</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getDiffTime <em>Diff Time</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getProgressionMode <em>Progression Mode</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getProgressionFactor <em>Progression Factor</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getForks <em>Forks</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeSet#getMasterFork <em>Master Fork</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTimeSet()
 * @model
 * @generated
 */
public interface TimeSet extends SuiteStatementWithResult
{
  /**
   * Returns the value of the '<em><b>Live</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Live</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Live</em>' attribute.
   * @see #setLive(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_Live()
   * @model
   * @generated
   */
  String getLive();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getLive <em>Live</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Live</em>' attribute.
   * @see #getLive()
   * @generated
   */
  void setLive(String value);

  /**
   * Returns the value of the '<em><b>Start Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Time</em>' containment reference.
   * @see #setStartTime(ValueOrEnumValueOrOperation)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_StartTime()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperation getStartTime();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getStartTime <em>Start Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Time</em>' containment reference.
   * @see #getStartTime()
   * @generated
   */
  void setStartTime(ValueOrEnumValueOrOperation value);

  /**
   * Returns the value of the '<em><b>Diff Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Diff Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Diff Time</em>' containment reference.
   * @see #setDiffTime(TimeDifference)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_DiffTime()
   * @model containment="true"
   * @generated
   */
  TimeDifference getDiffTime();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getDiffTime <em>Diff Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Diff Time</em>' containment reference.
   * @see #getDiffTime()
   * @generated
   */
  void setDiffTime(TimeDifference value);

  /**
   * Returns the value of the '<em><b>Progression Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Progression Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Progression Mode</em>' attribute.
   * @see #setProgressionMode(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_ProgressionMode()
   * @model
   * @generated
   */
  String getProgressionMode();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getProgressionMode <em>Progression Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Progression Mode</em>' attribute.
   * @see #getProgressionMode()
   * @generated
   */
  void setProgressionMode(String value);

  /**
   * Returns the value of the '<em><b>Progression Factor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Progression Factor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Progression Factor</em>' containment reference.
   * @see #setProgressionFactor(TimeProgressionFactor)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_ProgressionFactor()
   * @model containment="true"
   * @generated
   */
  TimeProgressionFactor getProgressionFactor();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getProgressionFactor <em>Progression Factor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Progression Factor</em>' containment reference.
   * @see #getProgressionFactor()
   * @generated
   */
  void setProgressionFactor(TimeProgressionFactor value);

  /**
   * Returns the value of the '<em><b>Forks</b></em>' reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ForkDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forks</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forks</em>' reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_Forks()
   * @model
   * @generated
   */
  EList<ForkDefinition> getForks();

  /**
   * Returns the value of the '<em><b>Master Fork</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Master Fork</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Master Fork</em>' attribute.
   * @see #setMasterFork(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeSet_MasterFork()
   * @model
   * @generated
   */
  String getMasterFork();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeSet#getMasterFork <em>Master Fork</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Master Fork</em>' attribute.
   * @see #getMasterFork()
   * @generated
   */
  void setMasterFork(String value);

} // TimeSet
