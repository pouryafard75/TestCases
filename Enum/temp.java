public class temp {
    int a  = 5;
    int b = 7;

    enum IntermediateType {
        OBJ,
        INT,
        NONE {
           @Override
           public boolean shouldUseIntermediate(boolean sorted, boolean distinct) {
              return false;
           }
        };
  
        public boolean shouldUseIntermediate(boolean sorted, boolean distinct) {
           return sorted || distinct;
        }
     }
    
}
