package dv.android.com.baseshop.utils;

public class Parameters {

    public enum ParametroTable{

        test(1L);

        private Long value;

        private ParametroTable(Long value){
            this.value = value;
        }

        public Long getValue(){
            return this.value;
        }
    }
}
