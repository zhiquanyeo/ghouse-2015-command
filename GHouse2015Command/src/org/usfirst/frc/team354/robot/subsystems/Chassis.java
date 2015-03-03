package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.OperatorMecDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController frontLeftMotor;
	private SpeedController frontRightMotor;
	private SpeedController backLeftMotor;
	private SpeedController backRightMotor;
	
	private RobotDrive driveSystem;
	
	public Chassis() {
		frontLeftMotor = new Victor(RobotMap.frontLeftMotor);
		frontRightMotor = new Victor(RobotMap.frontRightMotor);
		backLeftMotor = new Victor(RobotMap.backLeftMotor);
		backRightMotor = new Victor(RobotMap.backRightMotor);
		
		driveSystem = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
		
		driveSystem.setInvertedMotor(MotorType.kFrontLeft, true);
		driveSystem.setInvertedMotor(MotorType.kRearLeft, true);
	}
	
    public void initDefaultCommand() {
    	//The default command is to do meccanum drive. and it will be awesome
    	setDefaultCommand(new OperatorMecDrive(0.25));
    }
    
    public void meccanumDrive(double x, double y, double rotation) {
    	driveSystem.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
}

