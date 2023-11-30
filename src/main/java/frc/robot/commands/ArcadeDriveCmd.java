// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//Comment to test branch change.

package frc.robot.commands;


import frc.robot.subsystems.DriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDriveCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final DriveSubsystem driveSubsystem;
  private final Supplier<Double> speedFunction, turnFunction;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveCmd(DriveSubsystem driveSubsystem,
                        Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.driveSubsystem = driveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;
    driveSubsystem.setMotor(right, left);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
