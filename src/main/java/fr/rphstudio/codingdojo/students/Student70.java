/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;

import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

/**
 *
 * @author Romuald GRIGNON
 */
public class Student70 extends PodPlugIn {
    public Student70(Pod p){
        super(p);
    }

    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE

    int CpRace=0;  // Number of checkpoints
    int TuRace=0;  // Number of Laps
    int CpNext=0;  // Index of the next checkpoint
    int CpBef=0;   // Index of the last checkpoint
    float AgAct=0; // get the current angle
    float sxAct=0; // Actual x position
    float sxPrec=0; // Last x position
    float syAct=0; // Actual y position
    float syPrec=0; // Last y position
    float Ncpx=0;  // Next Checkpoint x position
    float Ncpy=0;  // Next Checkpoint y position
    float DistCp=0; // Distance between n and n-1 cp
    float DistPer=0; // percentage of travel

    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta)
    {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("70 - Banana");
        selectShip(1);
        setPlayerColor(255,255,255,255);

        CpRace=getNbRaceCheckPoints();
        TuRace=getNbMaxLaps();

        CpNext=getNextCheckPointIndex();
        if(CpNext>1){
            CpBef=CpNext-1;
        }
        else{
            CpBef=CpRace;
        }

        AgAct=getShipAngle();
        sxAct=getShipPositionX();
        sxPrec=getPreviousCheckPointX();
        syAct=getShipPositionY();
        syPrec=getPreviousCheckPointY();
        Ncpx=getNextCheckPointX();
        Ncpy=getShipSpeedY();
        (((sxPrec-sxAct)*(sxPrec-sxAct))+((syPrec-syAct)*(syPrec-syAct)))=DistCp;
        sqrt(DistCp);




        moveToNextCheckPoint(1f);


        // END OF CODE AREA
        //-------------------------------------------------------
    }

}