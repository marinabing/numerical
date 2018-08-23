/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public abstract class SingleValueRepresentation extends BaseFeatureVector {
    
    public static void main(String[] args) throws IOException {

        String input = null;

        Pattern fastaHeader = Pattern.compile("^\\>.*");

        try (Scanner readDataFile = new Scanner(new BufferedReader(new FileReader("filename.extension")));
                BufferedWriter outputReprFile = new BufferedWriter(new FileWriter("filename.extension"))) {

            while (readDataFile.hasNextLine()) {
                input = readDataFile.nextLine().toString();
                if (input.equalsIgnoreCase(fastaHeader.toString())) {
                    try {
                        outputReprFile.write(input);
                        readDataFile.nextLine();
                        
                    } finally {
                        System.out.println("In finally block");
                        if (outputReprFile != null) {
                            System.out.println("Closing output file");
                            outputReprFile.close();
                        }

                    }
                }
            }
}
    }
    protected Map<String, List<Double>> numValues = new HashMap<>();
    protected ISymbolSequence sequence;
    
    public SingleValueRepresentation(ISymbolSequence sequence) {
        this.sequence = sequence;
        assignValues();
        calculateVectorDimensions();
    }

    public List<Double> getSingleValueList(double element){
        List<Double> dlist = new LinkedList<>();
        dlist.add(element);
        return dlist;
    }
    
    public abstract void assignValues();


    public void calculateVectorDimensions(){
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            String sDimensionName = "X" + (iSymbolCnt + 1);
            // Assign the corresponding value from the atomicNumValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }            
    }
    
}