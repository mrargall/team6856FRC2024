// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
private final TalonFX armFx = new TalonFX(5);
private final int armRatio = 3*10;


  
  public ArmSubsystem() 
  {
    armFx.setInverted(false);

    armFx.setSelectedSensorPosition(0);
    armFx.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    armFx.setSensorPhase(true);
    armFx.setInverted(true);
    armFx.config_kF(0, 0);
    armFx.config_kP(0, 0.1);
    armFx.config_kI(0, 0.000001);
    armFx.config_kD(0, 0);
    armFx.configClosedLoopPeakOutput(0, 0.1);
    armFx.configAllowableClosedloopError(0, 0);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runTo(double pos)
  {
    armFx.set(TalonFXControlMode.Position, (int)((2048/360)*pos*armRatio));
  }

  public void stopArm() 
  {
    armFx.set(TalonFXControlMode.Current, 0);
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
