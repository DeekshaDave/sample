package com.example.finalproject.database;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MedDao_Impl implements MedDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfCreate;

  private final SharedSQLiteStatement __preparedStmtOfSave;

  private final SharedSQLiteStatement __preparedStmtOfDeleteContent;

  public MedDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfCreate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO medicine (name, dose) VALUES (?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfSave = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE medicine SET name = ?, dose = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteContent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM medicine WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void create(final String medName, final String dose) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfCreate.acquire();
    int _argIndex = 1;
    if (medName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, medName);
    }
    _argIndex = 2;
    if (dose == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dose);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfCreate.release(_stmt);
    }
  }

  @Override
  public void save(final String medName, final String dose, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSave.acquire();
    int _argIndex = 1;
    if (medName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, medName);
    }
    _argIndex = 2;
    if (dose == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dose);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSave.release(_stmt);
    }
  }

  @Override
  public void deleteContent(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteContent.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteContent.release(_stmt);
    }
  }

  @Override
  public List<Medicine> getMedList() {
    final String _sql = "SELECT * FROM medicine";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDose = CursorUtil.getColumnIndexOrThrow(_cursor, "dose");
      final List<Medicine> _result = new ArrayList<Medicine>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Medicine _item;
        _item = new Medicine();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.name = _cursor.getString(_cursorIndexOfName);
        _item.dose = _cursor.getString(_cursorIndexOfDose);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
