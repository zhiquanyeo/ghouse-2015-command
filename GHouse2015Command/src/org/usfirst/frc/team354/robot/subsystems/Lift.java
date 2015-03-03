package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.Robot;
import org.usfirst.frc.team354.robot.RobotMap;
import org.usfirst.frc.team354.robot.commands.StopLift;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController liftMotor;
	private Encoder encoder;
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	
	private boolean encoderReset = false;
	
	public Lift() {
		liftMotor = new Victor(RobotMap.liftMotor);
		encoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB, false, EncodingType.k4X);
		topSwitch = new DigitalInput(RobotMap.liftTopSwitch);
		bottomSwitch = new DigitalInput(RobotMap.liftBottomSwitch);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new StopLift());
    }
    
    public void raise() {
    	if (!isAtTop()) {
    		liftMotor.set(Constants.LIFT_MOTOR_SPEED);
    	}
    	else {
    		liftMotor.set(0);
    	}
    }
    
    public void lower() {
    	if (!isAtBottom()) {
    		liftMotor.set(-Constants.LIFT_MOTOR_SPEED);
    	}
    	else {
    		liftMotor.set(0);
    		encoder.reset();
    		encoderReset = true;
    	}
    }
    
    public void stop() {
    	liftMotor.set(0);
    }
    
    public boolean isAtTop() {
    	return (!topSwitch.get());
    }
    
    public boolean isAtBottom() {
    	return (!bottomSwitch.get());
    }
    
    public int encoderValue() {
    	return encoder.get();
    }
    
    public boolean encoderHasBeenReset() {
    	return encoderReset;
    }
    
    public boolean isAtSafeHeight() {
    	return (encoderReset && encoder.get() > Constants.LIFT_SAFE_HEIGHT);
    }
    
    // Initialization routines to run
    public void initialize() {
    	if (isAtBottom()) {
    		encoder.reset();
    		encoderReset = true;
    	}
    }
}

