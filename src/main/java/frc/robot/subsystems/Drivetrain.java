// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  PWMSparkMax m_leftMotor = new PWMSparkMax(0);
  PWMSparkMax m_rightMotor = new PWMSparkMax(1);
  PWMSparkMax m_rightMotor2 = new PWMSparkMax(2);
  PWMSparkMax m_leftMotor2 = new PWMSparkMax(3);
  MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);
  MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);
  DifferentialDrive m_roboDrive = new DifferentialDrive(leftMotorControllerGroup , rightMotorControllerGroup);
  /** Creates a new Drivetrain. */
  public Drivetrain() {
  //set up code
  leftMotorControllerGroup.setInverted(true);
  rightMotorControllerGroup.setInverted(false);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_roboDrive.tankDrive(leftSpeed, rightSpeed);
    m_roboDrive.feed();
    }

  public void arcadeDrive(double linear, double rotational) {
    m_roboDrive.arcadeDrive(linear, rotational);
    m_roboDrive.feed();
    }
  
    public void motorStop(){
      leftMotorControllerGroup.set(0);
      rightMotorControllerGroup.set(0);
    }
  
  



  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
