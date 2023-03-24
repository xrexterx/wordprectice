package com.xrexter.wordprectice

import androidx.room.*

@Entity
data class UserWords(
	@PrimaryKey val idx: Int,
	val english: String?,
	val korean: String?,
	val correct_count: Int,
	val wrong_count: Int
)

@Dao
interface UserWordsInterface {
	@Query("select * from UserWords")
	fun getAll(): List<UserWords>

	@Query("select idx from UserWords order by idx desc limit 1")
	fun getIndex(): Int

	@Insert
	fun insert(userWords: UserWords)
}

@Database(entities = [UserWords::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
	abstract fun userWordInterface(): UserWordsInterface
}