public class NotJavaException extends Exception
{
   //We will use this for our JavaOrNot class. This exception class
   // is for files that are not .java.
   public NotJavaException (String message) 
   {
      super(message);
    }
 }