package frc.robot.subsystems;

import limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 *
 */
public class myLimeLight extends SubsystemBase {

    private LimeLight m_limelight;

    public myLimeLight() {
        m_limelight = new LimeLight();
        //m_limelight = new LimeLight("limelight");
    }


    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public LimeLight getLimeLight(){
        return m_limelight;
    }
   
}