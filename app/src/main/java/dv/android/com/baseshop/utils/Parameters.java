package dv.android.com.baseshop.utils;

public class Parameters {

    //Estados utilizados en la aplicacion
    private static final String ACTIVO = "A";
    private static final String INACTIVO = "I";

    /**
     * Enum de la tabla Parametro
     */
    public enum ParametroTable{

        porcentaje_iva(1L), porcentaje_descuento(2L);

        private Long value;

        ParametroTable(Long value){
            this.value = value;
        }

        public Long getValue(){
            return this.value;
        }
    }
}
