const express = require("express");
const {
  getExpenses,
  getExpense,
  createExpense,
  updateExpense,
  deleteExpense,
  getCategorySummary,
  getMonthlySummary,
  getExpensesByCard
} = require("../controllers/expenseController");
const { protect } = require("../middleware/authMiddleware");

const router = express.Router();

// Protect all routes
router.use(protect);

// Fetch all expenses + create new one
router.route("/")
  .get(getExpenses)
  .post(createExpense);

// Get expenses filtered by card
router.route("/card/:cardId")
  .get(getExpensesByCard);

// Summary routes
router.route("/summary/category")
  .get(getCategorySummary);

router.route("/summary/monthly")
  .get(getMonthlySummary);

// Fetch single expense by ID | update | delete
router.route("/:id")
  .get(getExpense)
  .put(updateExpense)
  .delete(deleteExpense);

module.exports = router;
