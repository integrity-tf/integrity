/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.TimeDifference;
import de.gebit.integrity.dsl.TimeProgressionFactor;
import de.gebit.integrity.dsl.TimeSet;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getLive <em>Live</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getDiffTime <em>Diff Time</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getProgressionMode <em>Progression Mode</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getProgressionFactor <em>Progression Factor</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getForks <em>Forks</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeSetImpl#getMasterFork <em>Master Fork</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeSetImpl extends SuiteStatementImpl implements TimeSet
{
  /**
   * The default value of the '{@link #getLive() <em>Live</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLive()
   * @generated
   * @ordered
   */
  protected static final String LIVE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLive() <em>Live</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLive()
   * @generated
   * @ordered
   */
  protected String live = LIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartTime()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperation startTime;

  /**
   * The cached value of the '{@link #getDiffTime() <em>Diff Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiffTime()
   * @generated
   * @ordered
   */
  protected TimeDifference diffTime;

  /**
   * The default value of the '{@link #getProgressionMode() <em>Progression Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgressionMode()
   * @generated
   * @ordered
   */
  protected static final String PROGRESSION_MODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProgressionMode() <em>Progression Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgressionMode()
   * @generated
   * @ordered
   */
  protected String progressionMode = PROGRESSION_MODE_EDEFAULT;

  /**
   * The cached value of the '{@link #getProgressionFactor() <em>Progression Factor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgressionFactor()
   * @generated
   * @ordered
   */
  protected TimeProgressionFactor progressionFactor;

  /**
   * The cached value of the '{@link #getForks() <em>Forks</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForks()
   * @generated
   * @ordered
   */
  protected EList<ForkDefinition> forks;

  /**
   * The default value of the '{@link #getMasterFork() <em>Master Fork</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMasterFork()
   * @generated
   * @ordered
   */
  protected static final String MASTER_FORK_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMasterFork() <em>Master Fork</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMasterFork()
   * @generated
   * @ordered
   */
  protected String masterFork = MASTER_FORK_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeSetImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.TIME_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLive()
  {
    return live;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLive(String newLive)
  {
    String oldLive = live;
    live = newLive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__LIVE, oldLive, live));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueOrEnumValueOrOperation getStartTime()
  {
    return startTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStartTime(ValueOrEnumValueOrOperation newStartTime, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperation oldStartTime = startTime;
    startTime = newStartTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__START_TIME, oldStartTime, newStartTime);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartTime(ValueOrEnumValueOrOperation newStartTime)
  {
    if (newStartTime != startTime)
    {
      NotificationChain msgs = null;
      if (startTime != null)
        msgs = ((InternalEObject)startTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__START_TIME, null, msgs);
      if (newStartTime != null)
        msgs = ((InternalEObject)newStartTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__START_TIME, null, msgs);
      msgs = basicSetStartTime(newStartTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__START_TIME, newStartTime, newStartTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeDifference getDiffTime()
  {
    return diffTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDiffTime(TimeDifference newDiffTime, NotificationChain msgs)
  {
    TimeDifference oldDiffTime = diffTime;
    diffTime = newDiffTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__DIFF_TIME, oldDiffTime, newDiffTime);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiffTime(TimeDifference newDiffTime)
  {
    if (newDiffTime != diffTime)
    {
      NotificationChain msgs = null;
      if (diffTime != null)
        msgs = ((InternalEObject)diffTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__DIFF_TIME, null, msgs);
      if (newDiffTime != null)
        msgs = ((InternalEObject)newDiffTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__DIFF_TIME, null, msgs);
      msgs = basicSetDiffTime(newDiffTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__DIFF_TIME, newDiffTime, newDiffTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProgressionMode()
  {
    return progressionMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProgressionMode(String newProgressionMode)
  {
    String oldProgressionMode = progressionMode;
    progressionMode = newProgressionMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__PROGRESSION_MODE, oldProgressionMode, progressionMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeProgressionFactor getProgressionFactor()
  {
    return progressionFactor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProgressionFactor(TimeProgressionFactor newProgressionFactor, NotificationChain msgs)
  {
    TimeProgressionFactor oldProgressionFactor = progressionFactor;
    progressionFactor = newProgressionFactor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__PROGRESSION_FACTOR, oldProgressionFactor, newProgressionFactor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProgressionFactor(TimeProgressionFactor newProgressionFactor)
  {
    if (newProgressionFactor != progressionFactor)
    {
      NotificationChain msgs = null;
      if (progressionFactor != null)
        msgs = ((InternalEObject)progressionFactor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__PROGRESSION_FACTOR, null, msgs);
      if (newProgressionFactor != null)
        msgs = ((InternalEObject)newProgressionFactor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_SET__PROGRESSION_FACTOR, null, msgs);
      msgs = basicSetProgressionFactor(newProgressionFactor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__PROGRESSION_FACTOR, newProgressionFactor, newProgressionFactor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ForkDefinition> getForks()
  {
    if (forks == null)
    {
      forks = new EObjectResolvingEList<ForkDefinition>(ForkDefinition.class, this, DslPackage.TIME_SET__FORKS);
    }
    return forks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMasterFork()
  {
    return masterFork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMasterFork(String newMasterFork)
  {
    String oldMasterFork = masterFork;
    masterFork = newMasterFork;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_SET__MASTER_FORK, oldMasterFork, masterFork));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DslPackage.TIME_SET__START_TIME:
        return basicSetStartTime(null, msgs);
      case DslPackage.TIME_SET__DIFF_TIME:
        return basicSetDiffTime(null, msgs);
      case DslPackage.TIME_SET__PROGRESSION_FACTOR:
        return basicSetProgressionFactor(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.TIME_SET__LIVE:
        return getLive();
      case DslPackage.TIME_SET__START_TIME:
        return getStartTime();
      case DslPackage.TIME_SET__DIFF_TIME:
        return getDiffTime();
      case DslPackage.TIME_SET__PROGRESSION_MODE:
        return getProgressionMode();
      case DslPackage.TIME_SET__PROGRESSION_FACTOR:
        return getProgressionFactor();
      case DslPackage.TIME_SET__FORKS:
        return getForks();
      case DslPackage.TIME_SET__MASTER_FORK:
        return getMasterFork();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.TIME_SET__LIVE:
        setLive((String)newValue);
        return;
      case DslPackage.TIME_SET__START_TIME:
        setStartTime((ValueOrEnumValueOrOperation)newValue);
        return;
      case DslPackage.TIME_SET__DIFF_TIME:
        setDiffTime((TimeDifference)newValue);
        return;
      case DslPackage.TIME_SET__PROGRESSION_MODE:
        setProgressionMode((String)newValue);
        return;
      case DslPackage.TIME_SET__PROGRESSION_FACTOR:
        setProgressionFactor((TimeProgressionFactor)newValue);
        return;
      case DslPackage.TIME_SET__FORKS:
        getForks().clear();
        getForks().addAll((Collection<? extends ForkDefinition>)newValue);
        return;
      case DslPackage.TIME_SET__MASTER_FORK:
        setMasterFork((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TIME_SET__LIVE:
        setLive(LIVE_EDEFAULT);
        return;
      case DslPackage.TIME_SET__START_TIME:
        setStartTime((ValueOrEnumValueOrOperation)null);
        return;
      case DslPackage.TIME_SET__DIFF_TIME:
        setDiffTime((TimeDifference)null);
        return;
      case DslPackage.TIME_SET__PROGRESSION_MODE:
        setProgressionMode(PROGRESSION_MODE_EDEFAULT);
        return;
      case DslPackage.TIME_SET__PROGRESSION_FACTOR:
        setProgressionFactor((TimeProgressionFactor)null);
        return;
      case DslPackage.TIME_SET__FORKS:
        getForks().clear();
        return;
      case DslPackage.TIME_SET__MASTER_FORK:
        setMasterFork(MASTER_FORK_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TIME_SET__LIVE:
        return LIVE_EDEFAULT == null ? live != null : !LIVE_EDEFAULT.equals(live);
      case DslPackage.TIME_SET__START_TIME:
        return startTime != null;
      case DslPackage.TIME_SET__DIFF_TIME:
        return diffTime != null;
      case DslPackage.TIME_SET__PROGRESSION_MODE:
        return PROGRESSION_MODE_EDEFAULT == null ? progressionMode != null : !PROGRESSION_MODE_EDEFAULT.equals(progressionMode);
      case DslPackage.TIME_SET__PROGRESSION_FACTOR:
        return progressionFactor != null;
      case DslPackage.TIME_SET__FORKS:
        return forks != null && !forks.isEmpty();
      case DslPackage.TIME_SET__MASTER_FORK:
        return MASTER_FORK_EDEFAULT == null ? masterFork != null : !MASTER_FORK_EDEFAULT.equals(masterFork);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (live: ");
    result.append(live);
    result.append(", progressionMode: ");
    result.append(progressionMode);
    result.append(", masterFork: ");
    result.append(masterFork);
    result.append(')');
    return result.toString();
  }

} //TimeSetImpl
