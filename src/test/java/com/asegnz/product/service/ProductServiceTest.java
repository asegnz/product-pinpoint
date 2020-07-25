package com.asegnz.product.service;

import com.asegnz.product.model.Product;
import com.asegnz.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static com.asegnz.product.model.Product.productWithId;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    private ProductService sut;

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
        sut = new ProductService(repository);
    }

    @Test
    public void store() {
        doReturn(productWithId(example, ID)).when(repository).save(example);

        Long createdId = sut.store(example);

        assertEquals(ID, createdId);
        verify(repository).save(example);
    }

    @Test
    public void recoverAll() {
        doReturn(singletonList(productWithId(example, ID))).when(repository).findAll();

        List<Product> actual = sut.recoverAll();

        assertEquals(singletonList(productWithId(example, ID)), actual);
    }

    @Test
    public void recover() {
        Optional<Product> opt = Optional.of(productWithId(example, ID));
        doReturn(opt).when(repository).findById(ID);

        Product actual = sut.recover(ID);

        assertEquals(productWithId(example, ID), actual);
    }

}
