/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;

import java.io.FileWriter;
import java.io.IOException;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class PairedNumeric extends SingleValueRepresentation {

    public PairedNumeric(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getSingleValueList(-1.0));
        numValues.put("C", getSingleValueList(-1.0));
        numValues.put("A", getSingleValueList(1.0));
        numValues.put("T", getSingleValueList(1.0));
    }
    
   public static void pairedNumericRepresentation(FileWriter outputFile, String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        PairedNumeric pairedNumericRepr = new PairedNumeric(inputSeq);

        pairedNumericRepr.assignValues();

        pairedNumericRepr.calculateVectorDimensions();

        outputFile.write(pairedNumericRepr.toString() + "\n");
        outputFile.write(pairedNumericRepr.getDimensionNames() + "\n");
    }
    
}
