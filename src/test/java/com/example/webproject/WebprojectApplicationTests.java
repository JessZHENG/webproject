package com.example.webproject;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class WebprojectApplicationTests {
    @Autowired
    private InformationRepository informationRepository;

    @Test
    void saveRepositoryData(){
        informationRepository.deleteAll();

        informationRepository.save(new Information("Had I not seen the Sun",
                "I could have borne the shade",
                "But Light a newer Wilderness.My Wilderness has made."));
        informationRepository.save(new Information("There is room in the halls of pleasure",
                "For a long lordly train",
                "But one by one we must all fire on,Through thr narrow aisles of pain."));
        informationRepository.save(new Information("When you are old",
                "when you are old and grey and full of sleep",
                "And nodding by the fire,take down this book"));
        informationRepository.save(new Information("2020保研条例",
                "2020年新的保研条例",
                "保研的必须是个人！哈哈！"));

    }

    @Test
    void testInformationRepositoryFindByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable= PageRequest.of(0,20);
        String title="Sun";
        String summary="is";
        String content="down";
        Page<Information> page=informationRepository.findByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        System.out.println("============start 1");
        for(Information information:page){
            System.out.println(information.toString());
        }
        System.out.println("============end 1");

        title="2020";
        summary="保研";
        content="保研";
        page=informationRepository.findByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        System.out.println("============start 2");
        for(Information information:page){
            System.out.println(information.toString());
        }
        System.out.println("============end 2");

    }

    @Test
    void contextLoads() {
    }

}
