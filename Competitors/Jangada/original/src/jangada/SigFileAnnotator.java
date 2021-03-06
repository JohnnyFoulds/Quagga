package jangada;

import java.util.ArrayList;

import edu.cmu.minorthird.text.CharAnnotation;

/*
 *  This class implements an annotator for signature files extraction.
 *  
 * It first checks if the incoming message contains a sigfile; 
 * if it does, it extracts the signature file lines.
 *
 * @author Vitor R. Carvalho, May 2004
 */
 
public class SigFileAnnotator extends LocalStringAnnotator
{

  protected CharAnnotation[] annotateString(String spanString) 
  {  	
   		//first, detect if there is signature block in message
  		SigFileDetector det = new SigFileDetector();
 		boolean hasSig = det.hasSig(spanString);
  		if(!hasSig) {return null;}  		
  	  	
    	//parse string and return lines where were detected
    	//List list = new ArrayList();
    	SigFilePredictor sigpredictor = new SigFilePredictor();
    	ArrayList list = sigpredictor.Predict(spanString); 
//    	ArrayList list = sigpredictor.DetectAndPredict(spanString); 	
    	if(list.isEmpty()){return null;} 
    	CharAnnotation[] cann = (CharAnnotation[])list.toArray(new CharAnnotation[list.size()]);
       //  CharAnnotation[] cann =new CharAnnotation[1];
		return cann;

  }

  public String explainAnnotation(edu.cmu.minorthird.text.TextLabels labels, edu.cmu.minorthird.text.Span documentSpan)
  {
    return "not implemented yet - one day, maybe";
  }
}
