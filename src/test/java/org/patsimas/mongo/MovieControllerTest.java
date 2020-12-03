package org.patsimas.mongo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.patsimas.mongo.dto.MovieDto;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=MovieControllerTest",
        "spring.jmx.default-domain=MovieControllerTest"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieControllerTest extends BasicWiremockTest {

    @Test
    public void a_findAll() throws Exception {
        this.mockMvc.perform(get("/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void b_saveMovie() throws Exception {

        MovieDto movieDto = MovieDto.builder()
                .id(10)
                .title("ARIS")
                .genre(Stream.of("Action").collect(Collectors.toList()))
                .director("God")
                .year(1914)
                .revenue(Double.MAX_VALUE)
                .build();

        this.mockMvc.perform(post("/movies")
                .content(asJsonString(movieDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
