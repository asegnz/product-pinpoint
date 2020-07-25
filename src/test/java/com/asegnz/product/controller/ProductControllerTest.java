package com.asegnz.product.controller;

import com.asegnz.product.model.Product;
import com.asegnz.product.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.asegnz.product.model.Product.productWithId;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    private ProductController sut;

    private Product example = example();

    private static final Long ID = 1L;

    public Product example() {
        Product product = new Product();
        product.setProductName("ProductName");
        product.setDescription("Description");
        product.setPrice(121F);
        product.setQuantity(12);
        return product;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        sut = new ProductController(productService);
    }

    @Test
    public void newProduct() {
        doReturn(ID).when(productService).store(example);

        Long createdId = sut.newProduct(example);

        assertEquals(ID, createdId);
    }

    @Test
    public void all() {
        Product product = productWithId(example, ID);
        doReturn(asList(product)).when(productService).recoverAll();

        List<Product> list = sut.all();

        assertEquals(1, list.size());
        assertEquals(product, list.get(0));
    }

    @Test
    public void getProduct() {
        Product product = productWithId(example, ID);
        doReturn(product).when(productService).recover(ID);

        Product actual = sut.getProduct(ID);

        assertEquals(product, actual);
    }

}