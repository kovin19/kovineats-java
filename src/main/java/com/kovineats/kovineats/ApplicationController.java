package com.kovineats.kovineats;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kovineats.kovineats.Ingredientes.Ingredientes;
import com.kovineats.kovineats.Ingredientes.IngredientesServiceImp;
import com.kovineats.kovineats.Pedidos.Pedidos;
import com.kovineats.kovineats.Pedidos.PedidosServiceImp;
import com.kovineats.kovineats.Platillos.Platillos;
import com.kovineats.kovineats.Platillos.PlatillosServiceImp;
import com.kovineats.kovineats.Restaurantes.Restaurantes;
import com.kovineats.kovineats.Restaurantes.RestaurantesServiceImp;

@Controller
public class ApplicationController {

    private int contadorPedidos = 1;
    private final String[] repartidores_nombres = {"Claudio","Azucena","Alexandra","Nestor","Jonathan"};
    private final String[] repartidores_apellidos = {"Roca","Jimeno","Solis","Bolaños","Mayoral","Arenas","Muriel","Alcaide","Abellan","Valle"};

    private RestaurantesServiceImp restaurantesServiceImp;
    private PlatillosServiceImp platillosServiceImp;
    private IngredientesServiceImp ingredientesServiceImp;
    private PedidosServiceImp pedidosServiceImp;

    public ApplicationController(RestaurantesServiceImp restaurantesServiceImp, PlatillosServiceImp platillosServiceImp, 
        IngredientesServiceImp ingredientesServiceImp, PedidosServiceImp pedidosServiceImp) {
        this.restaurantesServiceImp = restaurantesServiceImp;
        this.platillosServiceImp = platillosServiceImp;
        this.ingredientesServiceImp = ingredientesServiceImp;
        this.pedidosServiceImp = pedidosServiceImp;
    }

    /*
     * Index
     * Obtiene todos los restaurantes y platillos
     */
    @RequestMapping(path = "/")
    public String index(Model model) {
        model.addAttribute("restaurantes", restaurantesServiceImp.getAllRestaurantes());
        model.addAttribute("platillos", platillosServiceImp.getAllPlatillos());
        return "index";
    }

    @RequestMapping(path = "/pedidos")
    public String pedidos(Model model) {
        model.addAttribute("pedidos", pedidosServiceImp.getAllPedidos());
        return "pedidos";
    }

    @RequestMapping(value = "/getRestaurante/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional <Restaurantes> getRestauranteById(@PathVariable Long id) {
        return restaurantesServiceImp.getRestauranteById(id);
    }

    @RequestMapping(value = "/getPlatillo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Platillos> getPlatilloById(@PathVariable Long id) {
        return platillosServiceImp.getPlatilloById(id);
    }

    @RequestMapping(value = "/getIngrediente/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Ingredientes> getIngredienteById(@PathVariable Long id) {
        return ingredientesServiceImp.getIngredienteById(id);
    }

    @RequestMapping(value = "/getPedido/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Pedidos> getPedidoById(@PathVariable Long id) {
        return pedidosServiceImp.getPedidoById(id);
    }

    /* Este método obtiene el JSON enviado desde el front
     * Y lo convierte a un objeto Pedido con sus atributos correspondientes
     * Genera un folio y un repartidor aleatorio y lo guarda en la base de datos
     * De ahí redirege al index
     */
    @RequestMapping(value = "/crearPedido", method = RequestMethod.POST, 
        consumes = org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void crearPedido(Pedidos pedido, HttpServletResponse response) throws IOException {
        pedido.setFolio(generateFolio(pedido.getFecha_pedido()));
        pedido.setRepartidor(generateRepartidor());
        pedidosServiceImp.savePedido(pedido);
        response.sendRedirect("/");
    }

    // Método para generar el folio
    public String generateFolio(String date) {
        date = date.replace("/", "");
        String folio = "KOVINEATS" + date + "000" + String.valueOf(contadorPedidos++);
        return folio;
    }

    // Método para generar el repartidor
    public String generateRepartidor() {
        Random rn = new Random();
        String nombre_repartidor = repartidores_nombres[rn.nextInt(5)];
        nombre_repartidor += " " + repartidores_apellidos[rn.nextInt(10)] + " " +repartidores_apellidos[rn.nextInt(10)];
        return nombre_repartidor;
    }

    // No sirve 
    // @RequestMapping(value = "/getIngredientesPlatillo/{id}", method = RequestMethod.GET)
    // @ResponseBody
    // public Set<Ingredientes> getIngredientesByPlatillo(@PathVariable("id") Long id, Model model) {
    //     System.out.println("ENTRA"); 
    //     Optional<Platillos> platillo_op = platillosServiceImp.getPlatilloById(id);
    //     Platillos platillo = platillo_op.get();
    //     model.addAttribute("ingredientes", platillosServiceImp.getIngredientesByPlatillo(platillo));
    //     return platillosServiceImp.getIngredientesByPlatillo(platillo);
    // }

}
