package designpattern;

import java.util.List;
import java.util.stream.Collectors;

public class OCP {

  enum Color {
    RED,
    GREEN,
    BLUE
  }

  enum Size {
    SMALL,
    MEDIUM,
    LARGE
  }

  interface Specification<T> {

    boolean isSatisfied(T item);
  }

  interface Filter<T> {
    List<T> filterItems(List<T> items, List<Specification<T>> specifications);
  }

  class Product {
    String name;
    Color color;
    Size size;
  }

  class ColorSpecifications implements Specification<Product> {

    Color color;

    public ColorSpecifications(Color color) {
      this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
      return item.color == color;
    }
  }

  class SizeSpecifications implements Specification<Product> {
    Size size;

    public SizeSpecifications(Size size) {
      this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
      return item.size == size;
    }
  }

  class AndSpecification implements Specification<Product> {

    List<Specification<Product>> specifications;

    public AndSpecification(List<Specification<Product>> specifications) {
      this.specifications = specifications;
    }

    @Override
    public boolean isSatisfied(Product item) {
      boolean ans = true;
      for (Specification<Product> specification : specifications) {
        ans = ans && specification.isSatisfied(item);
      }
      return ans;
    }
  }

  class BetterFilter implements Filter<Product> {

    @Override
    public List<Product> filterItems(
        List<Product> items, List<Specification<Product>> specifications) {
      AndSpecification andSpecification = new AndSpecification(specifications);
      return items.stream().filter(andSpecification::isSatisfied).collect(Collectors.toList());
    }
  }
}
