// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

private final WPI_TalonFX frontRight = new WPI_TalonFX(0);
private final WPI_TalonFX backRight = new WPI_TalonFX(2);
private final WPI_TalonFX frontLeft = new WPI_TalonFX(1);
private final WPI_TalonFX backLeft = new WPI_TalonFX(3);


  
  public DriveSubsystem() 
  {
    frontRight.setInverted(true);
    backRight.setInverted(true);
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

  
  public void setMotors(double leftSpeed, double rightSpeed){
      frontRight.set(rightSpeed);
      frontLeft.set(leftSpeed);
      backRight.set(rightSpeed);
      backLeft.set(leftSpeed);

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
