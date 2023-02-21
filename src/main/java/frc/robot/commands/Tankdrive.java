// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Tankdrive extends CommandBase {
  /** Creates a new Tankdrive. */
  Drivetrain drivetrain;
  DoubleSupplier leftSpeedDoubleSupplier;
  DoubleSupplier rightSpeedDoubleSupplier;

  public Tankdrive(Drivetrain drivetrain , DoubleSupplier leftSpeedDoubleSupplier, DoubleSupplier rightSpeedDoubleSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.leftSpeedDoubleSupplier = leftSpeedDoubleSupplier;
    this.rightSpeedDoubleSupplier = rightSpeedDoubleSupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.motorStop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.tankDrive (leftSpeedDoubleSupplier.getAsDouble(), rightSpeedDoubleSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
