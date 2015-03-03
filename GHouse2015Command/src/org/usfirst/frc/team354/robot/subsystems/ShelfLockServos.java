package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.CloseShelfLock;
import org.usfirst.frc.team354.robot.commands.OpenShelfLock;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShelfLockServos extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Servo leftServo;
	private Servo rightServo;
	
	public ShelfLockServos() {
		leftServo = new Servo(RobotMap.shelfServoLeft);
		rightServo = new Servo(RobotMap.shelfServoRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CloseShelfLock());
    }
    
    public void open() {
    	leftServo.setAngle(0);
    	rightServo.setAngle(175);
    }
    
    public void close() {
    	leftServo.setAngle(180);
    	rightServo.setAngle(0);
    	
    }
}

