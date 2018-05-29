package DataStrucuture;
import java.util.*;

    public class  CircleBufferQueue
    {

        public double[] buffer;          // Circular buffer
        public int      read, write;  // read and write pointers

        // Constructor
        public CircleBufferQueue(int size)
        {
            buffer = new double[size];    // Create array for circular buffer

            read = 0;                  // Initialized read & write pointers
            write = 0;
        }

        /* ====================================================
           enqueue(x ):
          ==================================================== */
        public void enqueue( double x )   throws Exception
        {
            if ( read == ( write + 1 ) % (buffer.length) )  // Full...
            {
                throw new Exception("Queue is full");
            }

            buffer[write] = x;                 // Store x in buf at write pointer
            write = (write+1)%(buffer.length); // Advance the write pointer
        }

        /* ====================================================
           dequeue():
          ==================================================== */
        public double dequeue( ) throws Exception
        {
            double result;   // Variable used to save the return value

            if ( read == write )
            {
                throw new Exception("Queue is empty");
            }

            result = buffer[read];                 // Save return value
            read = (read+1)%(buffer.length);  // Advance the read pointer

            return result;
        }
    }
