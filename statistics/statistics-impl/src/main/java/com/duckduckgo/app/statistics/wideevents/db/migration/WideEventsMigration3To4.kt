/*
 * Copyright (c) 2026 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.statistics.wideevents.db.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * v4 adds the `meta_type` and `meta_version` columns. Legacy rows keep a null type, which makes them
 * fall back to a type derived from the event name, and start at the initial schema version.
 */
internal val WideEventsMigration3To4 = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE wide_events ADD COLUMN meta_type TEXT")
        db.execSQL("ALTER TABLE wide_events ADD COLUMN meta_version TEXT NOT NULL DEFAULT '1.0.0'")
    }
}
