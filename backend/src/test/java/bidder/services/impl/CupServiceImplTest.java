package bidder.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/** Created by gawa on 24/05/17.*/
@RunWith(MockitoJUnitRunner.class)
public class CupServiceImplTest {

    @Test
    public void testMethod() {
        String myName = "My name";
        assertThat("My name", is( equalTo(myName)));
    }

}