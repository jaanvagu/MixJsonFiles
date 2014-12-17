package co.com.meridean.main;


import co.com.meridean.utils.Util;

public class main {



    public static void main(String[] args) throws Exception {

        Util util = new Util();
        util.mixJsonFiles("json_input/Responsabilidad_social.json", "json_input/ciudadania.json");
        util.mixJsonFiles("json_input/Situación_financiera.json", "json_input/finanzas.json");
        util.mixJsonFiles("json_input/Innovación_y_flexibilidad.json", "json_input/innovacion.json");
        util.mixJsonFiles("json_input/Integridad.json", "json_input/integridad.json");
        util.mixJsonFiles("json_input/Oferta.json", "json_input/oferta.json");
    }
}
