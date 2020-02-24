//package fr.oukonmange.api.test.rest;
//
//import fr.oukonmange.api.rest.OukonmangeController;
//import fr.oukonmange.data.dao.IUserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = OukonmangeController.class)
//public class OukonmangeControllerTest extends ControllerUtilsTest{
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @MockBean
//    private IUserRepository userRepository;
//
//    @Test
//    public void getAllUsersTest() throws Exception {
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/oukonmange/users")
//                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
//
//        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
//
//        verify(userRepository, times(1)).findAll();
//    }
//
////    @Test
////    public void testListPullRequest() throws Exception {
////
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/oukonmange/users")
////                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
////                .content(ControllerUtilsTest.asJsonString(pullRequestInformationIn));
////
////        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
////
////        verify(pullConfigManagement, times(1)).selectPullRequestOp(any(PullRequestInformationIn.class), anyString());
////        verify(pullRequestInformationOutErrorService, times(1)).detecterErreur(any(PullRequestInformationOut.class));
////    }
//
//}
