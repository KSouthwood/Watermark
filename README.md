# [Watermark](https://hyperskill.org/projects/222)

## About

Watermarking prevents unauthorized use of creative works without the
creators' permission. In this project, we will study how Kotlin can help us
apply a watermark to an image.

## Learning Outcomes

Learn one way to apply a watermark to an image. Come to know how to load,
save, handle and edit your images. In this project, employ various image
and file-specific classes that can be useful in many cases, not only for
applying watermarks.

### Stage 1: [Image properties](https://hyperskill.org/projects/222/stages/1112/implement)

#### _Images have various properties, like dimensions, various color schemes, and so on. In this stage, learn how to load images into our programs and retrieve their properties._

**Watermarking** is a popular method to claim ownership of an image. In
this project, you will learn to apply watermarks of 24-bit or 32-bit color
images with logos.

Before we start blending two images, you need to know how to get the image
properties. Images can be accessed in a `BufferedImage` instance with the
use of the `ImageIO` class. The image properties can be consequently
obtained by using that particular instance.

If `image` is a `BufferedImage` instance, then the following properties
can be acquired:

- Image height with `image.height` in pixels;
- Image width with `image.width` in pixels;
- The number of image components (can be colors or the alpha channel) with
  `image.colorModel.numComponents`;
- The number of image colors with `image.colorModel.numColorComponents`;
- The number of bits per pixel with `image.colorModel.pixelSize`;
- Image transparency setting with `image.transparency`.

The transparency property (`image.transparency`) can be either
`Transparency.OPAQUE`, `Transparency.BITMASK` or `Transparency.
TRANSLUCENT` (integers `1` to `3` respectively). Field descriptions can be
found in [Transparency](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Transparency.html); 
the correspondence is located between the field and the
values at [Constant Field Values](https://docs.oracle.com/en/java/javase/17/docs/api/constant-values.html) 
under the `java.awt.Transparency` header.

For example, a 24-bit color image (that is, three 8-bit colors) has 3
components, 3 colors, and the `OPAQUE` transparency (a value of `1`). A 32-bit
color image (three 8-bit colors and an alpha channel) has 4 components, 3
colors, and the `TRANSLUCENT` transparency (a value of `3`).

### Stage 2: [Blending images](https://hyperskill.org/projects/222/stages/1113/implement)

#### _Two images can be blended to produce a new image. This is also true when it comes to adding a watermark to an image. Let's start with combining two images of the same dimensions._

Text
