// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase ForwadRightTurnAuto(DriveSubsystem subsystem) {
  return Commands.sequence(
    new DriveForward(subsystem, 0.5*AutoConstants.SPEED, 0.5*AutoConstants.SPEED).withTimeout(1),
    new DriveForward(subsystem, AutoConstants.SPEED, (-AutoConstants.SPEED)).withTimeout(0.8),
    new DriveForward(subsystem, 0.5*AutoConstants.SPEED, 0.5*AutoConstants.SPEED).withTimeout(1)
  );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
