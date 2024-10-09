package com.example.kudago.service;

import com.example.kudago.model.Category;
import com.example.kudago.repo.CategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class CategoryServiceTest {
    @Mock
    private CategoryRepo categoryRepository;  // Замоканный репозиторий
    @InjectMocks
    private CategoryService categoryService;  // Тестируемый сервис
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Инициализация моков
    }
    // Позитивный сценарий: создание категории
    @Test
    public void testCreateCategory_Success() {
        Category category = new Category(1, "f", "Museum");
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        Category created = categoryRepository.save(category);
        assertNotNull(created);
        assertEquals("Museum", created.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    // Позитивный сценарий: поиск категории по ID
    @Test
    public void testGetCategoryById_Success() {
        Category category = new Category(1, "dfg","Museum");
        // Мокируем поведение репозитория, возвращая Optional
        when(categoryRepository.getCategoryById(1)).thenReturn(category);
        // Вызываем метод сервиса
        Category found = categoryService.getCategoryById(1);
        // Проверяем, что результат не null
        assertNotNull(found);
        // Проверяем имя категории
        assertEquals("Museum", found.getName());
        // Проверяем, что метод репозитория был вызван один раз
        verify(categoryRepository, times(1)).getCategoryById(1);
    }

    // Негативный сценарий: категория не найдена
    @Test
    public void testGetCategoryById_NotFound() {
        when(categoryRepository.getCategoryById(1)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> categoryService.getCategoryById(1));
        verify(categoryRepository, times(1)).getCategoryById(1);
    }

    // Негативный сценарий: удаление категории, которая не существует
    @Test
    public void testDeleteCategory_NotFound() {
        when(categoryRepository.getCategoryById(1)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> categoryService.deleteCategory(1));
        verify(categoryRepository, times(1)).getCategoryById(1);
    }
}