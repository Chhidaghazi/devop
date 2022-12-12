package tn.esprit.spring;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;

import tn.esprit.spring.services.VoyageurServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExamThourayaS2Application.class)
public class VoyageurServiceImplTest {

    @Mock
    private VoyageurRepository voyageurRepository;


    @InjectMocks
    VoyageurServiceImpl voyageurService;

    private Voyageur voyageur1 = new Voyageur(1L,"tes1");
    private Voyageur voyageur2 = new Voyageur(2L,"test2");

    @Test
    public void addvoyageurTest() {
        when(voyageurRepository.save(voyageur1)).thenReturn(voyageur1);
        assertNotNull(voyageur1);

        Voyageur persisted = voyageurService.ajouterVoyageur(voyageur1);
        assertEquals(voyageur1, persisted);

        System.out.println("add voyageur works !");
    }

    @Test
    public void retrieveAllVoyageurTest() {
        when(voyageurRepository.findAll()).thenReturn(Stream
                .of(voyageur1,voyageur2)
                .collect(Collectors.toList()));

        assertEquals(2,voyageurService.recupererAll().size());
        System.out.println("Retrieve all voyageur works !");
    }

    @Test
    public void UpdateVoyageurTest() {
        when(voyageurRepository.save(voyageur1)).thenReturn(voyageur1);
        assertNotNull(voyageur1);
        assertEquals(voyageur1, voyageurService.modifierVoyageur(voyageur1));
        System.out.println("Update voyageur works!");
    }

    @Test
    public void retrieveVoyageurTest() {
        when(voyageurRepository.findById(voyageur1.getIdVoyageur())).thenReturn(Optional.of(voyageur1));
        assertEquals(voyageur1, voyageurService.recupererVoyageParId(voyageur1.getIdVoyageur()));
        System.out.println("Retrieve voyageur by id works !");
    }


}
