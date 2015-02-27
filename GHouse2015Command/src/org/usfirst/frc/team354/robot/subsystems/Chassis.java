package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.OperatorHDrive;
import org.usfirst.frc.team354.robot.commands.OperatorMecDrive;

import edu.wpi.first.wpilibj.RobotDrive;
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
	
	//H Drive?
	private SpeedController hDriveMotor;

	private RobotDrive driveSystem;
	
	public Chassis() {
		frontLeftMotor = new Victor(RobotMap.frontLeftMotor);
		frontRightMotor = new Victor(RobotMap.frontRightMotor);
		backLeftMotor = new Victor(RobotMap.backLeftMotor);
		backRightMotor = new Victor(RobotMap.backRightMotor);
		hDriveMotor = new Victor(RobotMap.hDriveMotor);
		
		driveSystem = new RobotDrive(frontLeftMotor, frontRightMotor);
		
		//When we switch the mecanum, use this
		//driveSystem = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new OperatorHDrive());
    	
    	//TODO When we switch to Mec drive, use this
    	//setDefaultCommand(new OperatorMecDrive());
    }
    
    //This is the default drive system, with H drive
    public void hDrive(double speed, double turn, double strafe) {
    	driveSystem.arcadeDrive(speed, turn);
    	hDriveMotor.set(strafe);
    }
    
    public void meccanumDrive(double x, double y, double rotation) {
    	driveSystem.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
}

