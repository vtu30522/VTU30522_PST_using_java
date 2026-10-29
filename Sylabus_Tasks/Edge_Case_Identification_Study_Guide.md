# Edge Case Identification for Students
*Spot the tricky inputs before they break your program!*

---

## 1. Introduction: What is an Edge Case?

An **Edge Case** is a problem or situation that occurs only at an extreme (maximum or minimum) operating parameter, limit, or boundary of what a software program is designed to handle.

* **Key Concept:** Bugs love to hide at the edges! Most programmers write code that works well for typical, everyday situations, but the software fails when given extreme, empty, or unexpected values.
* **The Rule of Boundaries:** Edge cases live at the very edges of rules—the smallest allowed value, the biggest allowed value, the first item, the last item, or nothing at all.

### Everyday Metaphor: The Lift (Elevator)
Imagine an elevator with a capacity limit: **Maximum 8 people**.
* **0 People:** Empty lift (Special edge case: Should it move? Does the sensor sleep?)
* **1 to 7 People:** Normal zone (Everyday rides, works without issue).
* **8 People:** Exact limit (Edge case: Exactly at full capacity, doors should still close).
* **9+ People:** Overload / Invalid (Beyond the limit: Alarm buzzes, doors stay open, lift refuses to move).

---

## 2. Normal Zone vs. Edge Cases vs. Invalid Range

Consider a grading system where **valid test marks are from 0 to 100**:

| Zone | Value Range / Examples | Description | Behavior Expected |
| :--- | :--- | :--- | :--- |
| **Too Low (Invalid)** | `-1`, `-50` | Values strictly below the minimum allowed boundary | **Reject** with error |
| **Lower Edge** | `0`, `1` | Values right on the boundary and immediately inside | **Accept** |
| **Normal Zone** | `2` to `98` | Everyday standard values | **Accept** |
| **Upper Edge** | `99`, `100` | Values right inside and exactly on the maximum boundary | **Accept** |
| **Too High (Invalid)** | `101`, `200` | Values strictly above the maximum allowed boundary | **Reject** with error |

> **Takeaway:** Most inexperienced developers only test values between `2` and `98` (e.g., testing `50` or `75`). Software testers and edge detectives specifically target `0`, `1`, `99`, `100`, `-1`, and `101`.

---

## 3. Why Should We Care? (Real-World Failures)

When edge cases are ignored, real applications experience crashes, financial losses, and security vulnerabilities:

1. **Shopping App:**
   * **Input:** Quantity = `0` or negative.
   * **Failure:** An order for `0` items is processed and confirmed, or negative quantities subtract costs from the cart total.
2. **Video Game:**
   * **Input:** Player score exceeds the maximum integer limit (Integer Overflow).
   * **Failure:** The score flips from `2,147,483,647` into a negative score (`-2,147,483,648`), destroying player progress.
3. **Registration Form:**
   * **Input:** Age = `-5` or `999`.
   * **Failure:** Database accepts negative age or impossible human lifespan, corrupting downstream analytics and reports.

---

## 4. Boundary Value Testing: "Below, On, Above"

Whenever an input has limits, apply the **Below, On, Above** rule. For any boundary threshold, always test three specific points:
1. **Just Below:** One unit less than the threshold.
2. **Exactly On:** The exact boundary limit.
3. **Just Above:** One unit higher than the threshold.

### Example: Rule allows marks from `0` to `100`

* **Lower Boundary (0):**
  * `-1` (Just below) $\rightarrow$ **Reject**
  * `0` (On the limit) $\rightarrow$ **Accept**
  * `1` (Just inside) $\rightarrow$ **Accept**
* **Middle Point:**
  * `50` (Typical test) $\rightarrow$ **Accept**
* **Upper Boundary (100):**
  * `99` (Just inside) $\rightarrow$ **Accept**
  * `100` (On the limit) $\rightarrow$ **Accept**
  * `101` (Just above) $\rightarrow$ **Reject**

---

## 5. The "Sneaky Five" Inputs Checklist

Whenever you test any input field, function argument, or data structure, always question: **What happens with the Sneaky Five?**

1. **Empty (`""`, `null`, `[]`):**
   * Nothing typed, whitespace only, or an empty list.
2. **Zero (`0`, `0.0`):**
   * Can your program divide by it? Does it treat `0` as false or nonexistent?
3. **Negative (`-1`, `-99`):**
   * Quantities, prices, lengths, or ages that should never be negative.
4. **Huge / Maximum (`MAX_INT`, 1,000,000+):**
   * What if the number or string length exceeds buffer limits? Does one more break it?
5. **Wrong Data Type (`abc`, `!@#`):**
   * Entering letters, symbols, or floating-point decimals into an integer-only field.

---

## 6. Code Walkthrough: An Edge Case Bug in Java

### The Buggy Implementation
A program calculates the average mark from an array of integers:

```java
public class GradeAverage {
    public static int calculateAverage(int[] marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        // Bug occurs here if array has no elements!
        int avg = sum / marks.length; 
        return avg;
    }

    public static void main(String[] args) {
        int[] marks = {}; // Empty list passed as an edge case!
        System.out.println(calculateAverage(marks));
    }
}
```

### What Happens?
* Array is empty: `marks.length == 0`.
* Loop executes 0 times: `sum == 0`.
* Expression evaluated: `0 / 0`.
* **Result:** `java.lang.ArithmeticException: / by zero` $\rightarrow$ **CRASH!**

### The Fix
Always validate your collection lengths and edge states before mathematical operations:

```java
public static int calculateAverage(int[] marks) {
    // Guard clause checking edge case
    if (marks == null || marks.length == 0) {
        return 0; // Or throw a handled exception/return OptionalDouble
    }
    
    int sum = 0;
    for (int m : marks) {
        sum += m;
    }
    return sum / marks.length;
}
```

---

## 7. The 4-Step "Edge Detective" Methodology

Follow this systematic 4-step framework for every feature you code or test:

1. **Step 1: Read the Rule**
   * Identify what is legally allowed (e.g., *"Allowed numbers are 1 to 10"*).
2. **Step 2: Find the Limits**
   * Determine the absolute smallest and biggest values (e.g., `1` and `10`).
3. **Step 3: Pick the Tests**
   * Select values below, on, and above each limit (e.g., `0`, `1`, `10`, `11`).
4. **Step 4: Run, Fix, and Retest**
   * Did it crash or behave unexpectedly? Add guard clauses, handle exceptions, and retest until robust.

---

## 8. Interactive Practice: Password Rule Validation

**Requirement:** A password must be between **6 and 12 characters** long.

| Character Length | Category | Expected Application Behavior |
| :---: | :---: | :--- |
| `0` (Empty) | Edge Case (Extreme Lower) | **Reject** (Prompt: Password cannot be blank) |
| `5` | Edge Case (Just Below Min) | **Reject** (Prompt: Too short, minimum 6 characters) |
| `6` | Edge Case (On Lower Limit) | **Accept** |
| `8` | Normal Case (Comfortable Middle) | **Accept** |
| `12` | Edge Case (On Upper Limit) | **Accept** |
| `13` | Edge Case (Just Above Max) | **Reject** (Prompt: Too long, maximum 12 characters) |

---

## 9. Quick Quiz & Knowledge Check

1. **Question:** Pizza orders allow 1 to 10 pizzas. Which inputs are edge cases?
   * **Answer:** `0`, `1`, `10`, and `11` (specifically `10` and `1` on the boundaries, `0` and `11` just outside).
2. **Question:** A list of student marks is empty. What runtime error may occur during average calculation?
   * **Answer:** Division by zero (`ArithmeticException`).
3. **Question:** An age input allows 1 to 120. Is testing with `0` a normal test?
   * **Answer:** No, it is a boundary/edge case test (just below the minimum allowed age).
4. **Question:** A user types `"abc"` into an age or phone number field. What kind of test is this?
   * **Answer:** Wrong type / Invalid format test (part of the Sneaky Five).

---

## 10. Summary Cheat Sheet

* **Definition:** An edge case is an input at the extreme boundary (or just outside) of expected inputs.
* **Golden Rule:** Test **Below, On, and Above** every boundary.
* **The Sneaky Five to always test:**
  1. Empty (`""`, `[]`, `null`)
  2. Zero (`0`)
  3. Negative values
  4. Huge / Max values
  5. Incorrect types / strings in numbers
