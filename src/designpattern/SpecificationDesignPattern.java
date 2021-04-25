package designpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Color {
  RED,
  GREEN,
  BLUE
}

enum Size {
  S,
  M,
  L,
  XL
}

interface SpecificationSDP<T> {
  boolean isSatisfied(T item);
}

interface FilterSDP<T> {
  List<T> filter(List<T> items, SpecificationSDP<T> specifications);
}

class ProductSDP {
  Color color;
  Size size;

  public ProductSDP(Color color, Size size) {
    this.color = color;
    this.size = size;
  }

    @Override
    public String toString() {
        return "ProductSDP{" +
                "color=" + color +
                ", size=" + size +
                '}';
    }
}

class ColorSpecificationSDP implements SpecificationSDP<ProductSDP> {
  Color color;

  public ColorSpecificationSDP(Color color) {
    this.color = color;
  }

  @Override
  public boolean isSatisfied(ProductSDP item) {
    return item.color == color;
  }
}

class SizeSpecificationSDP implements SpecificationSDP<ProductSDP> {
  Size size;

  public SizeSpecificationSDP(Size size) {
    this.size = size;
  }

  @Override
  public boolean isSatisfied(ProductSDP item) {
    return item.size == size;
  }
}

class AndSpecificationSDP implements SpecificationSDP<ProductSDP> {
  List<SpecificationSDP<ProductSDP>> specificationSDPS = new ArrayList<>();

  public AndSpecificationSDP setSpecificationSDPS(SpecificationSDP<ProductSDP> specificationSDP) {
    this.specificationSDPS.add(specificationSDP);
    return this;
  }

  @Override
  public boolean isSatisfied(ProductSDP item) {
    return specificationSDPS.stream()
        .map(specificationSDP -> specificationSDP.isSatisfied(item))
        .reduce(true, (a, b) -> a && b);
  }
}

class BetterFilterSDP implements FilterSDP<ProductSDP> {

  @Override
  public List<ProductSDP> filter(
      List<ProductSDP> items, SpecificationSDP<ProductSDP> specificationSDP) {
    return items.stream().filter(specificationSDP::isSatisfied).collect(Collectors.toList());
  }
}

public class SpecificationDesignPattern {

  public static void main(String[] args) {
    //
    List<ProductSDP> productSDPS = new ArrayList<>();
    productSDPS.add(new ProductSDP(Color.RED, Size.S));
    productSDPS.add(new ProductSDP(Color.RED, Size.M));
    productSDPS.add(new ProductSDP(Color.BLUE, Size.L));
    productSDPS.add(new ProductSDP(Color.BLUE, Size.M));
    productSDPS.add(new ProductSDP(Color.GREEN, Size.XL));

    productSDPS =
        new BetterFilterSDP()
            .filter(
                productSDPS,
                new AndSpecificationSDP()
                    .setSpecificationSDPS(new ColorSpecificationSDP(Color.BLUE))
                    .setSpecificationSDPS(new SizeSpecificationSDP(Size.M)));

    productSDPS.forEach(x -> System.out.println(x.toString()));
  }
}
