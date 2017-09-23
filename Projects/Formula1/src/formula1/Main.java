package formula1;


import controlador.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import vista.VistaGlobal;
import vista.circuito.CircuitoView;
import vista.circuito.CircuitoViewImpl;
import vista.piloto.PilotoView;
import vista.piloto.PilotoViewImpl;






public class Main {


    
    public static void main(String[] args) {

        //Piloto
        PilotoModel pilotoModel=new PilotoModelImpl();

        
        PilotoView pilotoView1 =new PilotoViewImpl();
        List<PilotoView> pilotoViews= new ArrayList<PilotoView>();
        pilotoViews.add(pilotoView1);


        PilotoController pilotoController = new PilotoControllerImpl();
        
        pilotoController.setup(pilotoModel, pilotoViews);


        
        //Circuito
        CircuitoModel circuitoModel = new CircuitoModelImpl();


        CircuitoView circuitoView1 =new CircuitoViewImpl();
        List<CircuitoView> circuitoViews= new ArrayList<CircuitoView>();
        circuitoViews.add(circuitoView1);

        CircuitoController circuitoController = new CircuitoControllerImpl();

        circuitoController.setup(circuitoModel, circuitoViews);
        

        VistaGlobal vista1=new VistaGlobal(pilotoView1, circuitoView1);
        vista1.display();

    }

}
