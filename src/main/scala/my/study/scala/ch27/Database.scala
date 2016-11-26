//package my.study.scala.ch27
//
///**
// * Created by tianyuzhi on 16/9/29.
// */
//abstract class Database {
//  def allFoods: List[Food]
//
//  def allRecipes: List[Recipe]
//
//  def foodNamed(name: String) =
//    allFoods.find((f => f.name == name))
//
//  case class FoodCategory(name: String, food: List[Food])
//
//  def allCategories: List[FoodCategory]
//}
//
//abstract class Browser {
//  val database: Database
//
//  def recipesUsing(food: Food) =
//    database.allRecipes.filter(recipe => recipe.ingredients.contains(food))
//
//  def displayCategory(category: database.FoodCategory): Unit = {
//    print(category)
//  }
//}
//
//object OSimpleDatabase extends Database {
//  def allFoods = List(Apple, Orange, Cream, Sugar)
//
//  def allRecipes: List[Recipe] = List(FruitSalad)
//
//  private var categories = List(
//    FoodCategory("fruits", List(Apple, Orange)),
//    FoodCategory("misc", List(Cream, Sugar))
//  )
//
//  def allCategories = categories
//}
//
//object OSimpleBrowser extends Browser {
//  val dataBase = OSimpleDatabase
//}
//
//object StudentDatabase extends Database {
//
//  object FrozenFood extends Food("FrozenFood")
//
//  object HeatItUp extends Recipe(
//    "heat it up",
//    List(FrozenFood),
//    "Microwave the 'food' for 10 minutes."
//  )
//
//  def allFoods = List(FrozenFood)
//  def allRecipes = List(HeatItUp)
//  def allCategories = List(
//    FoodCategory("edible", List(FrozenFood))
//  )
//}
//
//object StudentBrowser extends Browser {
//  val database = StudentDatabase
//}