/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public class Tetrahedron implements IInput {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private LinkedList <Double> numericSequence;
    private HashMap<Character,List<Double>> tetraValues = new HashMap<>();
    
    private List<Double> indG = new ArrayList<>();
    private List<Double> indA = new ArrayList<>();
    private List<Double> indC = new ArrayList<>();
    private List<Double> indT = new ArrayList<>();

    
    
    public Tetrahedron(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

    @Override
    public int getExtendedInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getBase(int index) {
        
        System.out.println(convSeq[index]);
    }

    @Override
    public String asString() {
       return sequence.toString();
    }

    
    @Override
    public HashMap assignValues() {
       
       indG.add(0, -(Math.sqrt(2.0)/3));
       indG.add(1, -(Math.sqrt(6.0)/3));
       indG.add(2, -(1.0/3.0));
       indA.add(0, 0.0);
       indA.add(1, 0.0);
       indA.add(2, 1.0);
       indC.add(0, -(Math.sqrt(2.0)/3));
       indC.add(1, (Math.sqrt(6.0)/3));
       indC.add(2, -(1.0/3.0));
       indT.add(0, 2*(Math.sqrt(2.0)/3));
       indT.add(1, 0.0);
       indT.add(2, -(1.0/3.0));
        
       tetraValues.put('G', indG);
       tetraValues.put('A', indA);
       tetraValues.put('C', indC);
       tetraValues.put('T', indT);
       return tetraValues;
    }

//   public LinkedList toNumeric(){
//    for(int i=0; i<this.convSeq.length; i++){
//            if (tetraValues.containsKey(this.convSeq[i])){
//                
//                numericSequence.add(tetraValues.get(this.convSeq[i]));
//            }
//        }
//    
//    return numericSequence;
//    }
    
    
}